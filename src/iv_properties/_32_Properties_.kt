package iv_properties

import util.TODO
import util.doc32

class PropertyExample() {
    var counter = 0

    private var property = 0    // field seems not to be supported in this version
    var propertyWithCounter: Int
        get() = property
        set(value) {
            counter ++
            property = value
        }
}

fun todoTask32(): Nothing = TODO(
    """
        Task 32.
        Add a custom setter to PropertyExample.propertyWithCounter so that
        the 'counter' property is incremented every time 'propertyWithCounter' is assigned to.
    """,
    documentation = doc32(),
    references = { PropertyExample() }
)
