# frozen_string_literal: true
require_relative 'subway_card'
require_relative 'subway_central'

class RechargeableSubwayCard < SubwayCard
  def initialize(subway_central)
    @subway_central = subway_central
    @balance = 0
  end

  def recharge(amount)
    raise 'Invalid amount' unless amount.is_a?(Numeric) && amount.positive?
    @balance += amount
  end

  private def ride_cost
    @subway_central.ride_cost
  end

  private def ride?
    @balance >= self.ride_cost
  end

  def ride
    raise 'not enough funds' unless ride?
    @balance -= ride_cost
  end

  def to_s
    "Rechargeable #{super} [Balance: $#{@balance}]"
  end

end
