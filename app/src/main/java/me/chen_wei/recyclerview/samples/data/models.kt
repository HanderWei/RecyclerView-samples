package me.chen_wei.recyclerview.samples.data

/**
 * Created by Hander on 18/9/16.
 *
 * Email : hander_wei@163.com
 */
data class ItemData(val title: String, val message: String, val img: String)

data class Item(val title: String, val message: String, val img: String, val id: Int)

interface IRepository {
    fun getItems(): MutableList<Item>
    fun addItem(): List<Item>
    fun removeItem(): List<Item>
    fun changeItem(): List<Item>
    fun insertItem(): List<Item>
}

val fakeItems: List<ItemData> = listOf(
        ItemData("我一生见过很多黑暗，但永不及你暗无天日的人生", "但其他所有日本动画都可以追溯到手塚治虫的一拍三，本质是漫画的逻辑，也就是让漫画动起来，就像另一个回答所引安藤雅司的访谈讲的那样，漫画逻辑要求观众通过想象补完帧和帧之间（乃至场景和场景之间）的空白", "https://pic2.zhimg.com/v2-8312c2e6e50761bedc0c137e037d1575.jpg"),
        ItemData("身为医学博士，我得说新 Apple Watch 的心电图检测功能有点鸡肋", "首先要交代一下医学基本知识，心脏的每一次搏动都伴随着心脏电生理活动，通俗点说就是心脏的起博点通过放电，使电流传导到每个心肌纤维，接收到电信号后。", "https://pic3.zhimg.com/v2-e863f318a472b51761baf359b2528eae.jpg"),
        ItemData("每周一吸 · 凭什么说「好男不养猫」", "Apple Watch 上的 ECG 虽基于心电图原理，但由于只有两个电极，其呈现的波形只能叫做单导联心电图，仅具有常规心电图的部分功能。类似的其他产品，如 AliveCor Kardia Mobile ECG，早于去年就已问世。", "https://pic3.zhimg.com/v2-e766e8cdd416f8832abaed50465b0c52.jpg"),
        ItemData("有哪些流行的游戏战术是设计者肯定没想到的？", "一款成功的竞技游戏，一定会源源不断地产生一些设计者们意想不到的打法、战术，这是这一项目魅力的体现，也是它长久生命力的保证", "https://pic1.zhimg.com/v2-ab52a88604e8bf56d7d96482152c2110.jpg"),
        ItemData("万万没想到，你们竟然用这种操作玩我的游戏……", "玩家们在疯狂吐槽某种战术和打法太 IMBA，然而实际上，他们在开发阶段根本没有考虑到那种可能性，特定的打法、套路，都是由广大玩家自己钻研出来的。", "https://pic4.zhimg.com/v2-ee5277924f5559670aab018f990e2c5b.jpg"),
        ItemData("瞎扯 · 如何正确地吐槽", "那位老师只听见小姑娘用颤抖的哭腔重复一句话：「我是物质，你是意识，物质决定意识……」", "https://pic4.zhimg.com/v2-9815949cda3acd754bc2283f485f3807.jpg")
)

val fakeItem = ItemData("title", "message", "https://pic2.zhimg.com/v2-fceef07752a468ac7e8c760025034669.jpg")

object Repository: IRepository {

    private var list = mutableListOf<Item>()

    init {
        (0..20).forEach {
            val data = fakeItems[it % fakeItems.size]
            list.add(Item(data.title, data.message, data.img, it))
        }
    }

    override fun getItems(): MutableList<Item> {
        return list.toMutableList()
    }

    override fun addItem(): List<Item> {
        val data = fakeItems[list.size % fakeItems.size]
        list.add(Item(data.title, data.message, data.img, list.size))
        return list.toMutableList()
    }

    override fun removeItem(): List<Item> {
        list.removeAt(list.size - 1)
        return list.toMutableList()
    }

    override fun changeItem(): List<Item> {
        val data = fakeItem
        list[0] = Item(data.title, data.message, data.img, list[0].id)
        return list.toMutableList()
    }

    override fun insertItem(): List<Item> {
        val data = fakeItems[list.size % fakeItems.size]
        list.add(2, Item(data.title, data.message, data.img, list.size))
        return list.toMutableList()
    }

}
