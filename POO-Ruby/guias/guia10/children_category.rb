# frozen_string_literal: true

class ChildrenCategory < MovieCategory
  PRICE = 3
  LATE_PRICE = 1.5
  RENT_DAYS = 3
  def initialize
    super(PRICE, LATE_PRICE, RENT_DAYS)
  end
end
