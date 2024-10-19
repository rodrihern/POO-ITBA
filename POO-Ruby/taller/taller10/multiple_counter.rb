# frozen_string_literal: true

class MultipleCounter < Counter

  def initialize(step)
    super()
    @step = step
  end
  def increment
    @count += @step
  end
  def decrement
    @count -= @step
  end
end
