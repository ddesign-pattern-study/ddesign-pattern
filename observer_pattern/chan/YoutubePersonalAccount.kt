/**
 * 유튜브 개인 채널 계정
 *
 * 개인 채널은 주제이자 곧 옵저버이다.
 * 따라서 주제와, 옵저버를 모두 구현한다.
 */
class YoutubePersonalAccount(
    val name: String,
    private val pw: String,
    private val brandAccounts: MutableList<YoutubeBrandAccount> = mutableListOf(), // 개인 계정은 여러 브랜드 계정을 가질 수 있음
    override val channelName: String = name, // 채널 이름 = 계정 이름
    override val uploadedVideos: MutableList<Video> = mutableListOf(), // 업로드한 영상 목록
    override val subscribers: MutableSet<YoutubeChannelObserver> = mutableSetOf() // 개인 채널 구독자 목록
) : YoutubeChannel(), YoutubeChannelObserver {

    private val subscribedChannels: YoutubeSubscribedChannels by lazy { // 구독한 채널 목록
        YoutubeSubscribedChannels(this)
    }

    override fun update(channel: YoutubeChannel) {
        channel.getLatestVideo()?.let {
            println(
                """
                |[$name] < 디바이스 푸시알림 >
                |   ${channel.channelName} 채널 업로드 
                |   제목 : ${it.title} 
                |   썸네일 : ${it.thumbnailUrl}"    
                """.trimMargin()
            )
        }
    }

    fun getLatestVideos(): List<Video> {
        println("${name}님의 영상 리스트")
        return subscribedChannels
            .getLatestVideos()
            .also { if(it.isEmpty()) println("\t영상 없음") }
    }

    fun subscribeChannel(channel: YoutubeChannel) {
        subscribedChannels.subscribeChannel(channel)
    }

    fun unsubscribe(channel: YoutubeChannel) {
        subscribedChannels.unsubscribe(channel)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as YoutubePersonalAccount
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int = name.hashCode()

}