[![JitPack](https://jitpack.io/v/adrielcafe/KrumbsView.svg)](https://jitpack.io/#adrielcafe/KrumbsView) 
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) 
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-KrumbsView-green.svg?style=flat)]( https://android-arsenal.com/details/1/7562)

# KrumbsView
The ultimate breadcrumbs view for Android!

Inspired by [JotterPad](https://play.google.com/store/apps/details?id=com.jotterpad.x)'s breadcrumbs.

<img src="demo.gif" width="400px"/>

Features:

- [X] Custom typeface (from /assets and /res/font folders, also works with [Downloadable Fonts](https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts))
- [X] Customisable (text colors, text size, separator icon)
- [X] Cool animations
- [X] Swipe right to go back to the previous item
- [X] Survive Activity recreations
- [X] Extensible (open classes and protected members, extend it to get the job done!)

## How to use

### Import to your project

First, add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Next, add the dependency to your app modules:

```gradle
dependencies {
    ...
    compile 'com.github.adrielcafe:krumbsview:$latestVersion'
}
```

#### Current version: 

[![JitPack](https://jitpack.io/v/adrielcafe/KrumbsView.svg)](https://jitpack.io/#adrielcafe/KrumbsView)

### XML
```xml
<cafe.adriel.krumbsview.KrumbsView
    ...
    app:krumbsStartItem="[string]"
    app:krumbsTypeface="[string|font]"
    app:krumbsTextSize="[dimension]"
    app:krumbsBoldText="[true|false]"
    app:krumbsCurrentItemTextColor="[color]"
    app:krumbsPreviousItemTextColor="[color]"
    app:krumbsSeparatorTintColor="[color]"
    app:krumbsSeparatorIcon="[drawable]"
    app:krumbsAnimationType="[slideLeftRight|fadeInOut|growShrink]"
    app:krumbsAnimationDuration="[shortDuration|longDuration]"/>
```

Example:
```xml
<cafe.adriel.krumbsview.KrumbsView
    android:id="@+id/krumbsView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorPrimary"
    app:krumbsStartItem="Home"
    app:krumbsTypeface="@font/quicksand"
    app:krumbsTextSize="24sp"
    app:krumbsCurrentItemTextColor="@color/colorAccent"
    app:krumbsPreviousItemTextColor="@color/colorPrimaryDark"
    app:krumbsSeparatorTintColor="@color/colorPrimaryDark"
    app:krumbsSeparatorIcon="@drawable/ic_play_arrow"
    app:krumbsAnimationType="growShrink"
    app:krumbsAnimationDuration="longDuration"/>
```

### Kotlin/Java
```kotlin
with(krumbsView){
    size
    getItems()
    getCurrentItem()
    addItem(Krumb("Lorem Ipsum"))
    removeLastItem()
    removeAllItems()
    goToFirstItem()
    setOnPreviousItemClickListener { /* ... */ } // Swipe right also triggers this listener
    
    // All XML options are available
    setTypeface("fonts/quicksand.ttf") // From /assets folder
    setTypeface(R.font.quicksand) // From /res/font folder
    setTypeface(MyCustomTypeface)
    setTextSizeSp(20f)
    setTextSizePx(40f)
    setBoldText(true)
    setCurrentItemTextColor(Color.WHITE)
    setPreviousItemTextColor(color(R.color.transparent_white))
    setSeparatorTintColor(color(R.color.transparent_white))
    setSeparatorIcon(R.drawable.ic_keyboard_arrow_right)
    setAnimationType(KrumbsAnimationType.GROW_SHRINK)
    setAnimationDuration(KrumbsAnimationDuration.SHORT)
}
```

You can also use your custom Krumb implementation:
```kotlin
data class MyKrumb(val id: Int, 
                   val folderName: String, 
                   val createdAt: Date) : Krumb(folderName)

with(krumbsView){
    addItem(MyKrumb(123, "Folder XYZ", now))

    val myKrumb = getCurrentItem() as MyKrumb
}
```
