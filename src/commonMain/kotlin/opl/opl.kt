package opl

fun page(build: PageContext.() -> Unit): Page {
    return Page()
}

class Page

class PageContext {

    fun input(
        title: String,
    ): Input {
        return Input(id(), title)
    }

    fun select(
        title: String,
        values: Map<Int, String>,
    ): Select {
        return Select(id(), title, values)
    }

    fun button(
        title: String,
        action: Action,
    ): Button {
        return Button(id(), title, action)
    }

    fun table(
        store: Store,
    ): Table {
        return Table(id(), store)
    }

    fun store(): Store {
        return Store(id())
    }


    private fun id(): Id {
        return Id()
    }

}

class Id


abstract class Component(
    val id: Id,
)

class Input(
    id: Id,
    val title: String,
) : Component(id)

class Select(
    id: Id,
    val title: String,
    val values: Map<Int, String>,
) : Component(id)

class Button(
    id: Id,
    val title: String,
    val action: Action,
) : Component(id)

class Table(
    id: Id,
    val store: Store,
) : Component(id)


class Source(
    val url: String,
    val payload: Map<String, String>,
)


abstract class Action

class LoadData(
    val source: Source,
    val store: Store,
) : Action()


class Store(
    val id: Id,
)


fun ref(component: Component): String {
    return component.id.toString()
}
