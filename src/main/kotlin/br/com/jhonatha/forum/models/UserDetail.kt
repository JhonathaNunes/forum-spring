package br.com.jhonatha.forum.models

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetail(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> = user.roles

    override fun getPassword() = user.password

    override fun getUsername() = user.email
}