# frozen_string_literal: true

class SubwayStation
  include Comparable
  def initialize(name)
    @name = name
  end


  def to_s
    "Subway Station #{name}"
  end

  def <=>(other)
    @name <=> other.name
  end

  attr_reader :name
end


