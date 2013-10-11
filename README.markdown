# Introduction

When developing new DropWizard applications which require dynamic updates during development only then use this library.

Note: This should not be used for end user rendering - performance will be impacted.

# Usage

There are two options - to simply:

Add the following to your initialize method.

    bootstrap.addBundle(new NonCachineMustacheViewBundle());

But for Production applications you will want to:

Add the following to your initialize method.

    bootstrap.addBundle(new SwitchableMustacheViewBundle());

But default the views will not reload but if you specify "-Dmode=dev" as a java argument it will reload.