# frozen_string_literal: true

class Product
  attr_reader :price, :description
  def initialize(description, price)
    @description = description
    @price = price
  end
end
