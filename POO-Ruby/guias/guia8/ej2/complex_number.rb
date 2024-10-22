# frozen_string_literal: true

class ComplexNumber
  attr_reader :real, :imaginary

  def initialize(real, img)
    @real = real
    @imaginary = img
  end

  def +(other)
    ComplexNumber.new(self.real + other.real, self.imaginary + other.imaginary)
  end

  def to_s
    "#{real} + #{imaginary}i"
  end

end

first_complex = ComplexNumber.new(2, -1)
second_complex = ComplexNumber.new(3, 0)
res_complex = first_complex + second_complex
puts res_complex
# Imprime 5 + -1i

