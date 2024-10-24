# frozen_string_literal: true
class Item
  def initialize(product, amount)
    @product = product
    @amount = amount
  end

  def to_s
    "#{@product.description}\t#{@amount}  $#{@product.price}"
  end

  def subtotal
    @product.price * @amount
  end
end

class Ticket
  @@id = 1000

  def initialize
    @items = []
    @id = @@id
    @@id += 1
  end

  def add(product, amount)
    @items << Item.new(product, amount)
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
