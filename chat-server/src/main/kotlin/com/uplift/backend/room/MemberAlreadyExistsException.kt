package com.uplift.backend.room

/**
 * This class creates an exception if a user already exists in a session.
 *
 * @author David
 */
class MemberAlreadyExistsException: Exception(
    "There is already a member with that username in the room."
)