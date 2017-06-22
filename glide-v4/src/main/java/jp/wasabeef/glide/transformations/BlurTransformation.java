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
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.RSRuntimeException;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;

public class BlurTransformation implements Transformation<Bitmap> {

    private static final String CLASS_PATH = "jp.wasabeef.glide.transformations";
    private static final byte[] ID_BYTES = CLASS_PATH.getBytes(Charset.forName("UTF-8"));

    private static int MAX_RADIUS = 25;
    private static int DEFAULT_DOWN_SAMPLING = 1;

    private int mRadius;
    private int mSampling;

    public BlurTransformation(int radius) {
        this(radius, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int radius, int sampling) {
        mRadius = radius;
        mSampling = sampling;
    }

    @Override
    public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int outWidth, int outHeight) {
        Bitmap source = resource.get();

        int width = source.getWidth();
        int height = source.getHeight();
        int scaledWidth = width / mSampling;
        int scaledHeight = height / mSampling;

        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Bitmap bitmap;
        if (bitmapPool != null) {
            bitmap = bitmapPool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        canvas.scale(1 / (float) mSampling, 1 / (float) mSampling);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(source, 0, 0, paint);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            try {
                bitmap = RSBlur.blur(context, bitmap, mRadius);
            } catch (RSRuntimeException e) {
                bitmap = FastBlur.blur(bitmap, mRadius, true);
            }
        } else {
            bitmap = FastBlur.blur(bitmap, mRadius, true);
        }

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
