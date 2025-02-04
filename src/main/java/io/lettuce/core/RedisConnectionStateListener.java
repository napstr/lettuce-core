/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core;

import java.net.SocketAddress;

/**
 * Simple interface for Redis connection state monitoring.
 *
 * @author ze
 * @author Mark Paluch
 */
public interface RedisConnectionStateListener {

    /**
     * Event handler for successful connection event.
     *
     * @param connection Source connection.
     * @deprecated since 4.4, use {@link RedisConnectionStateListener#onRedisConnected(RedisChannelHandler, SocketAddress)}.
     */
    @Deprecated
    default void onRedisConnected(RedisChannelHandler<?, ?> connection) {
    }

    /**
     * Event handler for successful connection event. Delegates by default to {@link #onRedisConnected(RedisChannelHandler)}.
     *
     * @param connection Source connection.
     * @param socketAddress remote {@link SocketAddress}.
     * @since 4.4
     */
    default void onRedisConnected(RedisChannelHandler<?, ?> connection, SocketAddress socketAddress) {
        onRedisConnected(connection);
    }

    /**
     * Event handler for disconnection event.
     *
     * @param connection Source connection.
     */
    default void onRedisDisconnected(RedisChannelHandler<?, ?> connection) {
    }

    /**
     *
     * Event handler for exceptions.
     *
     * @param connection Source connection.
     *
     * @param cause Caught exception.
     */
    default void onRedisExceptionCaught(RedisChannelHandler<?, ?> connection, Throwable cause) {

    }

}
