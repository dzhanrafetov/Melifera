//package com.beesdev.shop.model
//
//import javax.persistence.*
//
//
//@Entity
//data class Role(
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        val id: Long,
//
//        val roleType: RoleType,
////mapped by
//        @ManyToMany(mappedBy = "roles")
//        val users: List<User>
//
//) {
//        override fun equals(other: Any?): Boolean {
//                if (this === other) return true
//                if (javaClass != other?.javaClass) return false
//
//                other as Role
//
//                if (id != other.id) return false
//                if (roleType != other.roleType) return false
//                if (users != other.users) return false
//
//                return true
//        }
//
//        override fun hashCode(): Int {
//                var result = id.hashCode()
//                result = 31 * result + roleType.hashCode()
//                result = 31 * result + users.hashCode()
//                return result
//        }
//}
//
//
//enum class RoleType{
//     ADMIN,USER
//}