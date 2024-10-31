# frozen_string_literal: true

class RecentCategory < MovieCategory
  PRICE = 3
  LATE_PRICE = 3
  RENT_DAYS = 1
  def initialize
    super(PRICE, LATE_PRICE, RENT_DAYS)
  end

  def points(days)
    days
  end
end
