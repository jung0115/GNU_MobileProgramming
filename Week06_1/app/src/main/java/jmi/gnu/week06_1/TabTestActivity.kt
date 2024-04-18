package jmi.gnu.week06_1

import android.app.TabActivity
import android.os.Bundle

class TabTestActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test)

        var tabHost = this.tabHost

        var tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        tabSpecSong.setContent(R.id.tab_song)
        tabHost.addTab(tabSpecSong)

        var tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별")
        tabSpecArtist.setContent(R.id.tab_artist)
        tabHost.addTab(tabSpecArtist)

        var tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별")
        tabSpecAlbum.setContent(R.id.tab_album)
        tabHost.addTab(tabSpecAlbum)

        tabHost.currentTab = 0
    }

}