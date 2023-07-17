/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.server.mock;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

class CustomPortTest {

  @Test
  void testWithStaticPort() throws IOException {
    KubernetesMockServer plainServer = new KubernetesMockServer(false);
    int availablePort = findAvailablePort();
    plainServer.init(InetAddress.getByName("0.0.0.0"), availablePort);
    Assertions.assertEquals(availablePort, plainServer.getPort());
    plainServer.destroy();
  }

  private static int findAvailablePort() throws IOException {
    try (ServerSocket socket = new ServerSocket(0)) {
      return socket.getLocalPort();
    }
  }
}
