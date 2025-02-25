package tachiyomi.domain.source.model

data class Source(
    val id: Long,
    val lang: String,
    val name: String,
    val supportsLatest: Boolean,
    val isStub: Boolean,
    val pin: Pins = Pins.unpinned,
    val isUsedLast: Boolean = false
) {

    val visualName: String
        get() = if (lang.isEmpty()) name else "$name (${lang.uppercase()})"

    val key: () -> String = {
        if (isUsedLast) "$id-lastused" else "$id"
    }
}
