package fi.oamk.todo.Model

class Task {
    var id: Int? = null
    var name: String? = null

    constructor()

    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

}
