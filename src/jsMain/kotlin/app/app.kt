package app

import dev.fritz2.core.`for`
import dev.fritz2.core.render
import dev.fritz2.core.storeOf
import dev.fritz2.core.value
import model.Framework
import model.name

fun main() {
    val frameworkStore = storeOf(Framework("fritz2"))
    val name = frameworkStore.map(Framework.name())

    render("#target") {
        div("form-group") {
            label {
                `for`("email")
                +"Email"
            }
            input("form-control", id = "email") {
            }
        }
        div("form-group") {
            label {
                `for`("type")
                +"Type"
            }
            select("form-control", id = "type") {
                option {
                    +"Monthly"
                    value("1")
                }
                option {
                    +"Infinite"
                    value("2")
                }
            }
        }
        div("form-group") {
            button("btn btn-primary") {
                +"Search"
            }
        }
        div("card-body") {
            table("table") {
                thead {
                    th {
                        +"column1"
                    }
                    th {
                        +"column2"
                    }
                }
                tbody {
                    tr {
                        td {
                            +"data1-1"
                        }
                        td {
                            +"data1-2"
                        }
                    }
                    tr {
                        td {
                            +"data2-1"
                        }
                        td {
                            +"data2-2"
                        }
                    }
                }
            }
        }
    }
}
