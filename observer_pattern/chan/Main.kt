fun main() {

    // 채널 생성
    val seoin = YoutubePersonalAccount(name = "서인", pw = "1234")
    val mamyo = YoutubePersonalAccount(name = "마묘", pw = "1234")
    val mamyoTV = YoutubeBrandAccount(personalAccount = mamyo, channelName = "마묘 고양이 TV") // 브랜드 채널
    val hasun = YoutubePersonalAccount(name = "하선", pw = "1234")
    val mulim = YoutubePersonalAccount(name = "무림", pw = "1234")
    val chan = YoutubePersonalAccount(name = "찬", pw = "1234")

    // 채널 구독
    seoin subscribe mamyoTV
    seoin subscribe chan
    hasun subscribe mamyoTV
    mulim subscribe mamyoTV
    println()

    // 영상 업로드 (푸시)
    mamyoTV upload (
        Video(
            title = "냥이의 일상",
            thumbnailUrl = "https://www.google.com/aclk?sa=l&ai=DChcSEwiGiYDX-I75AhXVwRYFHecqCZUYABAFGgJ0bA&sig=AOD64_08DIOw4c29tVucT1McNH-Fgwr9lw&adurl&ctype=5&ved=2ahUKEwiysPXW-I75AhXeRvUHHdHEBFMQvhd6BAgBEEI",
            videoUrl = "https://youtube.com/shorts/q9M4-Z9PbMQ"
        )
    )
    println()

    // 유튜브 영상 목록 조회
    hasun.getLatestVideos()
    mulim.getLatestVideos()
    seoin.getLatestVideos()
    println()

    chan upload (
        Video(
            title = "찬이의 엘라스틱 서치 인덱싱",
            thumbnailUrl = "https://www.google.com/aclk?sa=l&ai=DChcSEwiGiYDX-I75AhXVwRYFHecqCZUYABAFGgJ0bA&sig=AOD64_08DIOw4c29tVucT1McNH-Fgwr9lw&adurl&ctype=5&ved=2ahUKEwiysPXW-I75AhXeRvUHHdHEBFMQvhd6BAgBEEI",
            videoUrl = "https://youtube.com/shorts/q9M4-Z9PbMQ"
        )
    )
    println()

    // 채널 구독 해지
    hasun unsubscribe mamyoTV
    println()

    // 영상 업로드 (푸시)
    mamyoTV upload (
        Video(
            title = "뚱이의 일상",
            thumbnailUrl = "https://www.google.com/aclk?sa=l&ai=DChcSEwiGiYDX-I75AhXVwRYFHecqCZUYABAFGgJ0bA&sig=AOD64_08DIOw4c29tVucT1McNH-Fgwr9lw&adurl&ctype=5&ved=2ahUKEwiysPXW-I75AhXeRvUHHdHEBFMQvhd6BAgBEEI",
            videoUrl = "https://youtube.com/shorts/q9M4-Z9PbMQ"
        )
    )
    println()

    // 유튜브 영상 목록 조회
    hasun.getLatestVideos()
    mulim.getLatestVideos()
    seoin.getLatestVideos()

}