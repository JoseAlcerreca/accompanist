/*
 * Copyright 2020 The Android Open Source Project
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

package com.google.accompanist.imageloading.test

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toPixelMap
import com.google.common.truth.Truth.assertThat

/**
 * Assert that all of the pixels in this image as of the [expected] color.
 */
fun ImageBitmap.assertPixels(expected: Color, tolerance: Float = 0.0001f) {
    toPixelMap().buffer.forEach { pixel ->
        val color = Color(pixel)
        assertThat(color.red).isWithin(tolerance).of(expected.red)
        assertThat(color.green).isWithin(tolerance).of(expected.green)
        assertThat(color.blue).isWithin(tolerance).of(expected.blue)
        assertThat(color.alpha).isWithin(tolerance).of(expected.alpha)
    }
}
