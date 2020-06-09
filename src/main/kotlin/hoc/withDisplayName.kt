package hoc

import react.*
import kotlinext.js.*

fun <P : RProps> withDisplayName(
    name: String, fComp: FunctionalComponent<P>
): FunctionalComponent<P> =
    Object.assign(fComp, js {
        displayName = name
    })

