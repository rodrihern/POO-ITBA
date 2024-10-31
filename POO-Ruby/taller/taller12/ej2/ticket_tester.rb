require_relative 'product'
require_relative 'ticket'

bayaspirina = Product.new('Bayaspirina', 99.99)
cafiaspirina = Product.new('Cafiaspirina', 79.99)
aspirinetas = Product.new('Aspirinetas', 49.99)

first_ticket = Ticket.new
first_ticket.add(bayaspirina, 2)
first_ticket.add(cafiaspirina, 1)
puts first_ticket

# TICKET Nº 1000
# ####################
# Bayaspirina     2  $99.99
# Cafiaspirina    1  $79.99
# ####################
# TOTAL $279.97
puts

## voy a reescribir el spaceship de item para cambiar el spaceship

class Product
  def <=>(other)
    return nil unless other.is_a?(Product)
    [@description, @price] <=> [other.description, other.price]
  end
end

second_ticket = Ticket.new
second_ticket.add(bayaspirina, 1)
second_ticket.add(cafiaspirina, 1)
second_ticket.add(aspirinetas, 1)
puts second_ticket

# TICKET Nº 1001
# ####################
# # Aspirinetas     1  $49.99
# Bayaspirina     1  $99.99
# Cafiaspirina    1  $79.99
# ####################
# TOTAL $229.97
