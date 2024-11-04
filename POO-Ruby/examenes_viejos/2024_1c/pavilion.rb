# frozen_string_literal: true

class Pavilion
  include Comparable
  attr_reader :name, :cap
  def initialize(name, cap)
    @name = name
    @cap = cap
  end

  def ==(other)
    return false unless other.is_a?(Pavilion)
    [@name, @cap] == [other.name, other.cap]
  end
  alias_method :eql?, :==

  def hash
    [@name, @cap].hash
  end

  def <=>(other)
    return nil unless other.is_a?(Pavilion)
    self.to_s <=> other.to_s
  end

  def to_s
    "Pavilion #{@name} with cap #{@cap}"
  end
end
