# frozen_string_literal: true
v = [1, 5, 2]
p v.map { |item| item * 2}.reduce { |accum, e| accum + e}

v << 3
v.push(20)
p v.pop
p v