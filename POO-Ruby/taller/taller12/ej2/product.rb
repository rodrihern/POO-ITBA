# frozen_string_literal: true

class Product
  include Comparable
  attr_reader :price, :description
  def initialize(description, price)
    @description = description
    @price = price
  end

  def <=>(other)
    return nil unless other.is_a?(Product)
    [@price, @description] <=> [other.price, other.description]
  end

  def ==(other)
    return false unless other.is_a?(Product)
    other.description == @description && other.price == @price
  end
  alias_method :eql, :== ## no es necesario en sorted set

  def hash ## no es necesario en sorted set
    [@description, @price].hash
  end
end
