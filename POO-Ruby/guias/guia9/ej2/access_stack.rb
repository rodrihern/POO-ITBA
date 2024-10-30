# frozen_string_literal: true
require_relative 'stack'

class AccessStack < Stack
  attr_reader :pop_accesses

  def initialize
    super
    @pop_accesses = 0
  end

  def pop
    ans = super
    @pop_accesses += 1
    ans
  end

  def push_accesses
    @elements.size + @pop_accesses
  end
end
