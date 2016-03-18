# Refactoring
#
# The following function currently exists as is. Please refactor this code so that it's:
#
# - readable
# - testable
# - generally easier to work with.
#
# You do not need to write working code, just some pseudo code in the language of your choice.
#
# The key to this problem is to **CLEARLY EXPLAIN** why each change was made and how it helps with one of the following categories:
#
# - Readability
# - Testing
# - Reliability

def charge(payment_instrument_id, amount, description, processor):
    payment_instrument = models.PaymentInstrument.query.get(payment_instrument_id)
    if not payment_instrument:
        raise Exceptions.NotFound(payment_instrument_id)
    if amount >=0:
        raise Exceptions.Exception(amount + " must be supplied")
    if amount > 100000:
        raise Exceptions.Exception(amount + " is too large")
    description = description or "Default Description"
    if description.length > 22:
        description = description[:22]
    authorization = processor.authorize(payment_instrument, amount, description)
    debit = processor.capture(authorization, amount)
    if debit.success:
        return True
    return False
