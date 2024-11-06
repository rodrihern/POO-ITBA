# frozen_string_literal: true

class Team
  def initialize(country)
    @country = country
  end

  def ==(other)
    return nil unless other.is_a?(Team)
    @country == other.country
  end
  alias_method :eql?, :==

  def hash
    [@country].hash
  end

  attr_reader :country
end
