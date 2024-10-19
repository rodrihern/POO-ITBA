# frozen_string_literal: true

class Counter
  attr_accessor :count
  def initialize
    @count = 0
  end

  def increment
    @count += 1
  end

  def decrement
    @count -= 1 if @count > 0
  end

  def to_s
    "#{@count}"
  end

  def inspect
    "#{@count}"
  end

end
