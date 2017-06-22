package jp.wasabeef.glide.transformations;

/**
 * Copyright (C) 2017 Wasabeef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * This class is modified for Glide v4.
 * Base source code is from
 *
 * https://github.com/wasabeef/glide-transformations
 *
 * created by Wasabeef.
 *
 * I changed constructors and other overrode methods
 * because there are some differences between
 * #{@link com.bumptech.glide.load.Transformation} in v3
 * and it in v4.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class GrayscaleTransformation implements Transformation<Bitmap> {

    private static final String CLASS_PATH = "jp.wasabeef.glide.transformations";
    private static final byte[] ID_BYTES = CLASS_PATH.getBytes(Charset.forName("UTF-8"));

    @Override
    public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int outWidth, int outHeight) {
        Bitmap source = resource.get();

        int width = source.getWidth();
        int height = source.getHeight();

        Bitmap.Config config =
                source.getConfig() != null ? source.getConfig() : Bitmap.Config.ARGB_8888;

        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Bitmap bitmap;
        if (bitmapPool != null) {
            bitmap = bitmapPool.get(width, height, config);
        } else {
            bitmap = Bitmap.createBitmap(width, height, config);
        }

        Canvas canvas = new Canvas(bitmap);
        ColorMatrix saturation = new ColorMatrix();
        saturation.setSaturation(0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(saturation));
        canvas.drawBitmap(source, 0, 0, paint);

        return BitmapResource.obtain(bitmap, bitmapPool);
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        if (messageDigest != null) {
            messageDigest.update(ID_BYTES);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BlurTransformation;
    }

    @Override
    public int hashCode() {
        return CLASS_PATH.hashCode();
    }
}
