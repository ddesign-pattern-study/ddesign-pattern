// Infix Function 정의

infix fun YoutubePersonalAccount.subscribe(other: YoutubeChannel) =
    this.subscribeChannel(other)

infix fun YoutubePersonalAccount.unsubscribe(other: YoutubeChannel) =
    this.unsubscribe(other)

infix fun YoutubeChannel.upload(other: Video) =
    this.uploadVideo(other)