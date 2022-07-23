/**
 * 유튜브 채널 추상 클래스
 *
 * 채널이기 때문에 주제 인터페이스를 구현한다.
 */
abstract class YoutubeChannel : YoutubeChannelSubject {

    abstract val channelName: String // 채널 이름

    protected abstract val uploadedVideos: MutableList<Video> // 업로드한 영상 목록
    protected abstract val subscribers: MutableSet<YoutubeChannelObserver> // 구독자 목록

    override fun registerObserver(o: YoutubeChannelObserver) { // 구독자 추가
        if(!subscribers.contains(o))
            subscribers.add(o)
    }

    override fun removeObserver(o: YoutubeChannelObserver) { // 구독자 삭제
        subscribers.remove(o)
    }

    override fun notifyObservers() { // 구독 알림
        subscribers.forEach { it.update(this) }
    }

    fun getLatestVideo(): Video? = uploadedVideos.lastOrNull() // 최신 영상 조회

    fun uploadVideo(video: Video) { // 영상 업로드
        println("--- $channelName 채널 영상 업로드 [${video.title}] ---")
        uploadedVideos.add(video)
        notifyObservers()
    }

}