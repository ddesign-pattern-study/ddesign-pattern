/**
 * 유튜브 주제 인터페이스
 */
interface YoutubeChannelSubject {
    fun registerObserver(o: YoutubeChannelObserver)
    fun removeObserver(o: YoutubeChannelObserver)
    fun notifyObservers()
}