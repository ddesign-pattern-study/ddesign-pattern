/**
 * 구독한 유튜브 채널 일급 컬렉션.
 */
class YoutubeSubscribedChannels(
    private val personalAccount: YoutubePersonalAccount,
    private val subscribedChannels: MutableList<YoutubeChannel> = mutableListOf()
) {

    fun getLatestVideos(): List<Video> =
        subscribedChannels
            .mapIndexedNotNull { index, channel ->
                channel
                    .getLatestVideo()
                    ?.also {
                        println("\t${index.plus(1)}. ${it.title}")
                    }
            }

    fun subscribeChannel(channel: YoutubeChannel) {
        channel.registerObserver(personalAccount)
        subscribedChannels.add(channel)
        println("${personalAccount.name}님이 ${channel.channelName} 채널을 구독하였습니다.")
    }

    fun unsubscribe(channel: YoutubeChannel) {
        channel.removeObserver(personalAccount)
        subscribedChannels.remove(channel)
        println("${personalAccount.name}님이 ${channel.channelName} 채널을 구독 해지하였습니다.")
    }

}