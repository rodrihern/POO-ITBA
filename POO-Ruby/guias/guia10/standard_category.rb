# frozen_string_literal: true

class StandardCategory < MovieCategory
  PRICE = 2
  LATE_PRICE = 1.5
  RENT_DAYS = 2
  def initialize
    super(PRICE, LATE_PRICE, RENT_DAYS)
  end
end
