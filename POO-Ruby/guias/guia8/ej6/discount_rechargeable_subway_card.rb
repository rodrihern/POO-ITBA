# frozen_string_literal: true
require_relative 'rechargeable_subway_card'

class DiscountRechargeableSubwayCard < RechargeableSubwayCard
  def initialize(subway_central, discount_percentage)
    super(subway_central)
    raise 'invalid discount' unless discount_percentage.is_a?(Numeric) && discount_percentage.positive?
    @dp = discount_percentage
  end

  private def ride_cost
    super * (1 - @dp)
  end
end
