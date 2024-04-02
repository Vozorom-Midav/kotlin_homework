fun main() {

    var command: String? = ""
    var name: String? = ""
    var error: Boolean
    while (command != "exit"){
        command = readlnOrNull()
        if(command == "help") {
            println(
                "exit - выйти\n" +
                        "help - помощь\n" +
                        "add <Имя> phone <Номер телефона> - добавить имя и номер телефона\n" +
                        "add <Имя> email <Адрес электронной почты> - добавить имя и email"
            )
        }
        else if(command!!.startsWith("add")){
            val comAr = command.split(" ")
            for(i in 0..<comAr.size){
                if(comAr[i] == "add") {
                    name = comAr[i + 1]
                    error = true
                    for(j in i..<comAr.size-1){
                        if (comAr[j] == "phone" && comAr[j + 1].matches(Regex("""[0-9+]{11,12}"""))) {
                            val phone = comAr[j + 1]
                            println("Вы добавили запись\n" + "Имя: $name \n" + "Номер телефона: $phone")
                            error = false
                        } else if (comAr[j] == "email" && comAr[j + 1].matches(Regex("""[a-zA-Z]{3}@[a-zA-Z]{3,8}.[a-zA-Z]{2,3}"""))) {
                            val email: String = comAr[j + 1]
                            println("Вы добавили запись\n" + "Имя: $name \n" + "Email: $email")
                            error = false
                        }
                    }
                    if(error) {
                        println("Ошибка. Неверный формат ввода. Попробуйте снова.")
                    }
                }
            }
        }
        else if(command != "exit"){
            println("Ошибка. Неверная команда. Попробуйте снова.")
        }
    }
}

