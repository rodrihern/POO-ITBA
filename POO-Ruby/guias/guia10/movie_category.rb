# frozen_string_literal: true

class MovieCategory
  def initialize(price, late_price, rent_days)
    @price = price
    @late_price = late_price
    @rent_days = rent_days
  end

  def charge(days)
    return @price + (days - @rent_days) * @late_price if days > @rent_days
    @price
  end

  def points(days)
    1
  end

end
