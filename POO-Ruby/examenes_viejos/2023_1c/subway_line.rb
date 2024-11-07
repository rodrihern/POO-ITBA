# frozen_string_literal: true

class SubwayLine
  include Comparable
  def initialize(letter)
    @letter = letter
  end


  def to_s
    "Subway Line #{letter}"
  end

  alias_method :eql?, :==

  def hash
    [@letter].hash
  end

  def <=>(other)
    return nil unless other.is_a?(SubwayLine)
    @letter <=> other.letter
  end


  attr_reader :letter
end
