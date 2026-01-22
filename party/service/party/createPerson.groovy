import org.moqui.context.ExecutionContext
ExecutionContext ec = context.ec
if (!context.partyId) {
    ec.message.addError("partyId is required")
    return
}
if (!context.firstName) {
    ec.message.addError("firstName is required")
    return
}
if (!context.lastName) {
    ec.message.addError("lastName is required")
    return
}

// Verify Party exists
def party = ec.entity.find("party.Party")
        .condition("partyId", context.partyId)
        .one()

if (!party) {
    ec.message.addError("No Party found for partyId: ${context.partyId}")
    return
}

def person = ec.entity.makeValue("party.Person")
person.setFields(context, true, null, null)
person.create()

context.responseMessage ="Person ${firstName} ${lastName} ban gya!!"
