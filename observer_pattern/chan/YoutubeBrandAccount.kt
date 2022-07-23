/**
 * 유튜브 브랜드 채널 계정
 */
class YoutubeBrandAccount(
    val personalAccount: YoutubePersonalAccount,
    override val channelName: String,
    override val uploadedVideos: MutableList<Video> = mutableListOf(),
    override val subscribers: MutableSet<YoutubeChannelObserver> = mutableSetOf(),
) : YoutubeChannel()