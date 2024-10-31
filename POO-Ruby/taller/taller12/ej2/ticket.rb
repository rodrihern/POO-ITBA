# frozen_string_literal: true
require 'sorted_set'

class Item
  attr_reader :product, :amount
  include Comparable
  def initialize(product, amount)
    @product = product
    @amount = amount
  end

  def <=>(other)
    return nil unless other.is_a?(Item)
    @product <=> other.product
  end

  def ==(other)
    return false unless other.is_a?(Item)
    @product == other.product
  end
  alias_method :eql?, :== ## no es necesario en sorted set

  def hash ## no es necesario en sorted set
    [@product].hash
  end

  def to_s
    "#{@product.description}\t#{@amount}  $#{@product.price}"
  end

  def increment_amount(increment)
    @amount += increment
  end

  def subtotal
    @product.price * @amount
  end
end

class Ticket
  @@id = 1000

  def initialize
    @items = SortedSet.new
    @id = @@id
    @@id += 1
  end


  def add(product, amount)
    @items.add(Item.new(product, amount))
  end

  private def total
    @items.map { |item| item.subtotal }.reduce {:+}
  end

  def to_s
    s = "Ticket N #{@id}\n##########\n"
    @items.each {|item| s += "#{item.to_s}\n"}
    s += "##########"
  end
end
