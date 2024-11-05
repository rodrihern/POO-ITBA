# frozen_string_literal: true

class Section
  def initialize(name)
    @name = name
  end

  def ==(other)
    name == other.name
  end
  alias_method :eql?, :==

  def hash
    @name.hash
  end

  attr_accessor :name

end
