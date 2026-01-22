import org.moqui.context.ExecutionContext
// ExecutionContext import kiya gaya hai
// Ye Moqui ka main context hota hai jisse entity, message, service sab access hota hai

ExecutionContext ec = context.ec
// Service context se ExecutionContext object nikala
// "ec" short reference ke liye use ho raha hai

if (!context.partyId) {
    // Check: agar partyId input me nahi aaya
    ec.message.addError("partyId is required")
    // Error message add kar diya
    return
    // Service execution yahin stop ho jaayega
}

if (!context.firstName) {
    // Check: firstName mandatory hai
    ec.message.addError("firstName is required")
    return
}

if (!context.lastName) {
    // Check: lastName bhi required hai
    ec.message.addError("lastName is required")
    return
}

// Verify Party exists
// Ab ye ensure kar rahe hain ki jo partyId diya gaya hai
// wo Party table me exist bhi karta hai ya nahi

def party = ec.entity.find("party.Party")
        .condition("partyId", context.partyId)
        .one()
// party.Party entity me search ho rahi hai
// condition: partyId = input partyId
// .one() ka matlab: ek hi record expected hai

if (!party) {
    // Agar Party nahi mili
    ec.message.addError("No Party found for partyId: ${context.partyId}")
    // Proper error message return kar diya
    return
    // Aage Person create nahi hoga
}

def person = ec.entity.makeValue("party.Person")
// party.Person entity ka ek naya empty object banaya gaya
// Abhi DB me insert nahi hua hai

person.setFields(context, true, null, null)
// context se matching fields automatically Person entity me set ho jaayenge
// true → sirf entity ke defined fields hi lenge
// null, null → koi include/exclude list nahi

person.create()
// Yahan actual database insert hota hai
// party.Person table me record save ho jaata hai

context.responseMessage = "Person ${firstName} ${lastName} ban gya!!"
// Service ka output parameter set kiya gaya
// Ye message REST / screen / Postman ko response me milega
