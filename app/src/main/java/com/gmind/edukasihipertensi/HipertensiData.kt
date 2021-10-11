package com.gmind.edukasihipertensi

object HipertensiData {

    private val judulData = arrayOf(
        "Pengertian",
        "Tanda dan Gejala",
        "Penyebab",
        "Heavy Bowgun",
        "Hunting Horn",
        "Hammer",
        "Light Bowgun",
        "Lance",
        "Long Sword",
        "Vidio Edukasi",
        "Indeks Massa Tubuh")

    private val deskripsiData = arrayOf(
        "Lorem ipsum dolor sit amet, \n" +
                "consectetur adipiscing elit, sed do \n" +
                "eiusmod tempor incididunt ut \n" +
                "labore et dolore magna aliqua. Ut \n" +
                "enim ad minim veniam, quis \n" +
                "nostrud exercitation ullamco \n" +
                "laboris nisi ut aliquip ex ea \n" +
                "commodo consequat. Duis aute \n" +
                "irure dolor in reprehenderit in \n" +
                "voluptate velit esse cillum dolore \n" +
                "eu fugiat nulla pariatur. Excepteur \n" +
                "sint occaecat cupidatat non \n" +
                "proident, sunt in culpa qui officia \n" +
                "deserunt mollit anim id est \n" +
                "laborum.Lorem ipsum dolor sit \n" +
                "amet, consectetur adipiscing elit, \n" +
                "sed do eiusmod tempor incididunt \n" +
                "ut labore et dolore magna aliqua. \n" +
                "Ut enim ad minim veniam, quis \n" +
                "nostrud exercitation ullamco \n" +
                "laboris nisi ut aliquip ex ea \n" +
                "commodo consequat. Duis aute \n" +
                "irure dolor in reprehenderit in \n" +
                "voluptate velit esse cillum dolore \n" +
                "eu fugiat nulla pariatur. Excepteur \n" +
                "sint occaecat cupidatat non \n" +
                "proident, sunt in culpa qui officia \n" +
                "deserunt mollit anim id est \n" +
                "laborum.\n",
        "A lance equipped with the ability to fire shells. Has high attack potential thanks to Wyvern's Fire and Burst Fire, which fires all of your shells at once. The Gunlance offers more offensive power than the lance thanks to the addition of shelling attacks, and it also has good guarding capabilities. It may take time to master.",
        "A mighty sword that makes up for its lack of mobility with huge, punishing attacks. The Great Sword can also block attacks, making it a good all-around weapon. The great sword has a long reach and powerful attacks. Because its sheer weight limits the speed of your movement and attacks, it lends itself well to hit-and-run combat tactics.",
        "A powerful, long range projectile weapon. The heavy weight makes mobility a chore, but firepower makes up for it. Use Crouching Fire to rapidly chain together shots. The bowgun can be used to attack monsters from long range. There are two types of bowgun: the heavy bowgun, which can use powerful ammo, and the light bowgun, which allows for greater mobility and evasive capabilities, and faster shooting.",
        "A blunt weapon used to smash monsters with powerful attacks. It can stun monsters with repeated blows to the head. The hunting horn is a blunt weapon that can bestow positive status effects on yourself and your allies. Use it to perform melodies that can boost attack power, restore health, and grant other beneficial effects.",
        "A blunt weapon used to smash monsters with powerful attacks. It can stun monsters with repeated blows to the head. The hammer is a powerful blunt weapon with a surprising amount of mobility. It's also possible to stun monsters by delivering a hammer attack to the head.",
        "A short range projectile weapon. Utilizes a variety of ammo to do everything from rapidly shooting targets to providing support with status-changing ammo. The Bowgun can be used to attack monsters from long range. There are two types of Bowgun: the Heavy Bowgun, which  is generally slower, more powerful, and has access to high-damage ammo, and the Light Bowgun, which allows for greater mobility and evasive capabilities, and faster shooting.",
        "A weapon coupled with a highly defensive shield. Lance users can block while moving and also counter-attack. You can also charge forward with this weapon and perform a Jumping Attack. The lance is better at guarding than any other weapon. In addition to its long reach, its thrust attacks can be executed with little exposure to enemy attacks. Great for defense-oriented combat.",
        "A nimble weapon capable of extended combos.Charge up energy with each attack to use your powerful Spirit Blade. The long sword enables fast, fluid movement and combos, but it cannot be used to guard.",
        "Use the mobility and attack power of the Axe, and when you see a chance, switch to the powerful Sword. While in Sword Mode, aim to unleash a powerful Element Discharge. The switch axe morphs between axe and sword modes. Axe mode boasts power and long reach, while sword mode features faster attacks and explosive finishers. ",
        "Indeks Massa Tubuh")

    private val iconData = intArrayOf(
        R.drawable.ic_pengertian,
        R.drawable.ic_gejala,
        R.drawable.ic_penyebab,
        R.drawable.hbg,
        R.drawable.hh,
        R.drawable.hm,
        R.drawable.lbg,
        R.drawable.lc,
        R.drawable.ls,
        R.drawable.sa,
        R.drawable.sa)

    private val assetData = intArrayOf(
            R.drawable.ic_pengertian,
            R.drawable.ic_gejala,
            R.drawable.ic_penyebab,
            R.drawable.hbg,
            R.drawable.hh,
            R.drawable.hm,
            R.drawable.lbg,
            R.drawable.lc,
            R.drawable.ls,
            R.raw.test,
            R.drawable.ic_penyebab)




    val listData: ArrayList<Hipertensi>
        get() {
            val list = arrayListOf<Hipertensi>()
            for (position in judulData.indices) {
                val hipertensi = Hipertensi()
                hipertensi.contentJudul = judulData[position]
                hipertensi.contentDeskripsi = deskripsiData[position]
                hipertensi.contentIcon = iconData[position]
                hipertensi.contentAsset = assetData[position]
                list.add(hipertensi)
            }
            return list
        }
}