# frozen_string_literal: true

class Stack
  def initialize
    @elements = []
  end

  def empty?
    @elements.empty?
  end

  def push(elem)
    @elements.push(elem)
  end

  def pop
    empty_check
    @elements.pop
  end

  def peek
    empty_check
    @elements.last
  end

  private def empty_check
    raise 'Stack is empty' if empty?
  end

  def to_s
    @elements.to_s
  end

end
