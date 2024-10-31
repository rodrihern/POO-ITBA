# frozen_string_literal: true

class Customer
  attr_reader :points, :charge

  def initialize(name)
    @name = name
    @points = 0
    @charge = 0
  end

  def add_charge(charge)
    @charge += charge
  end

  def add_points(points)
    @points += points
  end

end
