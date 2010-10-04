/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.jms;

import org.springframework.integration.Message;
import org.springframework.integration.channel.AbstractMessageChannel;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.Assert;

/**
 * @author Mark Fisher
 * @since 2.0
 */
public class AbstractJmsChannel extends AbstractMessageChannel {

	private final JmsTemplate jmsTemplate;


	public AbstractJmsChannel(JmsTemplate jmsTemplate) {
		Assert.notNull(jmsTemplate, "jmsTemplate must not be null");
		this.jmsTemplate = jmsTemplate;
	}


	JmsTemplate getJmsTemplate() {
		return this.jmsTemplate;
	}

	@Override
	protected boolean doSend(Message<?> message, long timeout) {
		this.jmsTemplate.convertAndSend(message);
		return true;
	}

}