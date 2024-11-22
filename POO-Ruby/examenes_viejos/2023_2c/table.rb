# frozen_string_literal: true

class Table
  include Comparable

  def initialize(name, capacity, section_name)
    @name = name
    @capacity = capacity
    @section_name = section_name
  end

  def <=>(other)
    return nil unless other.is_a?(Table)
    [other.capacity, name] <=> [@capacity, other.name]
  end

  def to_s
    "Table #{@name} for #{@capacity} people in section #{@section_name}"
  end

  attr_accessor :name, :capacity
end
